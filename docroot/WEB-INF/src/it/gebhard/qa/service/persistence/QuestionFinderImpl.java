package it.gebhard.qa.service.persistence;

import it.gebhard.qa.model.Question;
import it.gebhard.qa.model.Tag;
import it.gebhard.qa.model.impl.QuestionImpl;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

// Custom SQL Queries in Liferay:
// http://www.liferay.com/community/wiki/-/wiki/Main/Service+Builder+Finders
// http://www.liferay.com/de/community/wiki/-/wiki/Main/Custom+queries+in+Liferay
public class QuestionFinderImpl extends BasePersistenceImpl<Question> implements QuestionFinder {

	@SuppressWarnings("unchecked")
	public List<Question> findQuestionsByTitleAndTags(String title, List<Tag> tags, boolean unansweredFirst, int begin, int end) throws SystemException {
		Session session = null;
		try {
			String sql = generateTitleAndTagsQuery(title, tags, unansweredFirst);
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("Question", QuestionImpl.class);
			query.setCacheable(false);
			if (title != null && title.length() > 0) {
				QueryPos qPos = QueryPos.getInstance(query);
				qPos.add("%" + title + "%");
			}
			return (List<Question>) QueryUtil.list(query, getDialect(), begin, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}

	private String generateTitleAndTagsQuery(String title, List<Tag> tags, boolean unansweredFirst) {
		if (tags != null && tags.size() > 0) {
			String sql = "SELECT * FROM (" + generateTitleQuery(title, unansweredFirst) + " UNION ALL " + generateTagsQuery(tags, unansweredFirst) + ") ";
			sql += "ORDER BY numAnswers asc, created desc ";
			return sql;
		}
		return generateTitleQuery(title, unansweredFirst) + "ORDER BY numAnswers asc, created desc ";
	}

	private String generateTitleQuery(String title, boolean unansweredFirst) {
		boolean titleDefined = title != null && title.length() > 0;
		String sql = "SELECT q.*, ";
		if (unansweredFirst)
			sql += "a.numAnswers ";
		else
			sql += "1 as numAnswers ";
		sql += "FROM QuickAnswer_Question q ";
		if (unansweredFirst) {
			sql += "LEFT OUTER JOIN (SELECT questionId, count(*) as numAnswers FROM QuickAnswer_Answer GROUP BY questionId) a ON a.questionID = q.questionId ";
		}
		if (titleDefined) {
			sql += "WHERE q.title LIKE ? ";
		}
		return sql;
	}

	private String generateTagsQuery(List<Tag> tags, boolean unansweredFirst) {
		boolean tagsDefined = tags != null && tags.size() > 0;
		String sql = "SELECT q.*, ";
		if (unansweredFirst)
			sql += "a.numAnswers ";
		else
			sql += "1 as numAnswers ";
		sql += "FROM QuickAnswer_Question q ";

		if (unansweredFirst) {
			sql += "LEFT OUTER JOIN (SELECT questionId, count(*) as numAnswers FROM QuickAnswer_Answer GROUP BY questionId) a ON a.questionID = q.questionId ";
		}
		if (tagsDefined) {
			sql += "INNER JOIN QuickAnswer_QuestionTag qt ON qt.questionId = q.questionId ";
		}
		if (tagsDefined) {
			sql += "WHERE qt.tagId IN (";
			boolean firstTag = true;
			for (Tag tag : tags) {
				if (!firstTag) {
					sql += ", ";
				}
				firstTag = false;
				sql += tag.getTagId();
			}
			sql += ") ";
		}
		return sql;
	}

}
