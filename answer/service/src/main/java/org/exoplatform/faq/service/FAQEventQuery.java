/*
 * Copyright (C) 2003-2008 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */
package org.exoplatform.faq.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.exoplatform.commons.utils.ISO8601;
import org.exoplatform.forum.common.CommonUtils;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public abstract class FAQEventQuery implements FAQNodeTypes {

  public static final String FAQ_CATEGORY               = "faqCategory";

  public static final String FAQ_QUESTION               = "faqQuestion";

  public static final String CATEGORY_AND_QUESTION      = "categoryAndQuestion";

  private static Log         log                        = ExoLogger.getLogger(FAQEventQuery.class);

  private String             type;

  private String             text;

  private String             name;

  private String             isModeQuestion;

  private String             moderator;

  private String             path;

  private String             author;

  private String             userId;

  private String             questionDisplayMode;

  private String             email;

  private String             question;

  private String             response;

  private String             comment;
  
  private String             asteriskConditionSearch;

  private String             attachment;

  private List<String>       userMembers;

  private Calendar           fromDate;

  private Calendar           toDate;

  private String             language;

  private boolean            isAnd                      = false;

  private boolean            isAdmin                    = false;

  private boolean            isExcerpt                 = false;

  private boolean            isQuestionLevelSearch      = false;

  private boolean            isLanguageLevelSearch      = false;

  private boolean            isAnswerCommentLevelSearch = false;

  private boolean            isSearchOnDefaultLanguage  = false;

  private List<String>       viewingCategories;

  private int                offset                     = 0;

  private int                limit                      = 0;

  private String             sort                       = "";//date, title, relevancy

  private String             order                      = "ASC";// (ASC, DESC)

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public void setQuestionDisplayMode(String questionDisplayMode) {
    this.questionDisplayMode = questionDisplayMode;
  }

  public String getQuestionDisplayMode() {
    return questionDisplayMode;
  }

  /**
   * Instantiates a new fAQ event query.
   */
  public FAQEventQuery() {
    viewingCategories = new ArrayList<String>();
  }

  /**
   * Gets the type.
   * 
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the type.
   * 
   * @param type the new type
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Gets the text.
   * 
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the text.
   * 
   * @param text the new text
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets the name.
   * 
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the checks if is mode question.
   * 
   * @param isModeQuestion the new checks if is mode question
   */
  public void setIsModeQuestion(String isModeQuestion) {
    this.isModeQuestion = isModeQuestion;
  }

  /**
   * Gets the checks if is mode question.
   * 
   * @return the checks if is mode question
   */
  public String getIsModeQuestion() {
    return isModeQuestion;
  }

  /**
   * Sets the name.
   * 
   * @param name the new name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the moderator.
   * 
   * @return the moderator
   */
  public String getModerator() {
    return moderator;
  }

  /**
   * Sets the moderator.
   * 
   * @param moderator the new moderator
   */
  public void setModerator(String moderator) {
    this.moderator = moderator;
  }

  /**
   * Gets the path.
   * 
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * Sets the path.
   * 
   * @param path the new path
   */
  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Gets the author.
   * 
   * @return the author
   */
  public String getAuthor() {
    return author;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  /**
   * Sets the author.
   * 
   * @param author the new author
   */
  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Gets the email.
   * 
   * @return the checks if is lock
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the email.
   * 
   * @param email the new email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets the question.
   * 
   * @return the question
   */
  public String getQuestion() {
    return question;
  }

  /**
   * Sets the question.
   * 
   * @param question the new question
   */
  public void setQuestion(String question) {
    this.question = question;
  }

  /**
   * Gets the response.
   * 
   * @return the response
   */
  public String getResponse() {
    return response;
  }

  /**
   * Sets the response.
   * 
   * @param response the new response
   */
  public void setResponse(String response) {
    this.response = response;
  }

  /**
   * Gets the attachment.
   * 
   * @return the attachment
   */
  public String getAttachment() {
    return attachment;
  }

  /**
   * Sets the attachment.
   * 
   * @param attachment the new attachment
   */
  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }

  /**
   * @return the userMembers
   */
  public List<String> getUserMembers() {
    return userMembers;
  }

  /**
   * @param userMembers the userMembers to set
   */
  public void setUserMembers(List<String> userMembers) {
    this.userMembers = userMembers;
  }

  /**
   * Gets the from date.
   * 
   * @return the from date
   */
  public Calendar getFromDate() {
    return fromDate;
  }

  /**
   * Sets the from date.
   * 
   * @param fromDate the new from date
   */
  public void setFromDate(Calendar fromDate) {
    this.fromDate = fromDate;
  }

  /**
   * Gets the to date.
   * 
   * @return the to date
   */
  public Calendar getToDate() {
    return toDate;
  }

  /**
   * Sets the to date.
   * 
   * @param toDate the new to date
   */
  public void setToDate(Calendar toDate) {
    this.toDate = toDate;
  }

  /**
   * Gets the checks.
   * 
   * @return the checks if is true or false
   */
  public boolean getIsAnd() {
    return this.isAnd;
  }

  /**
   * @return the isAdmin
   */
  public boolean isAdmin() {
    return isAdmin;
  }

  /**
   * @param isAdmin the isAdmin to set
   */
  public void setAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  /**
   * This method is query on search 
   * Gets the path query.
   * 
   * @return string the path query
   */
  public String getQuery() throws Exception {
    StringBuilder queryString = new StringBuilder();

    // ######################### Category Search ###########################
    if (type.equals(FAQ_CATEGORY)) { // Category Search
      queryString = buildSQLCategoryQuery();
      // ###################### Question Search ############################
    } else if (type.equals(FAQ_QUESTION)) {
      queryString = buildSQLQuestionQuery();
      // ###################### Quick Search ###############################
    } else if (type.equals(CATEGORY_AND_QUESTION)) {

      queryString = buildSQLCategoryAndQuestionQuery();
    }
    if (log.isDebugEnabled()) {
      log.debug(queryString.toString());
    }
    return queryString.toString();
  }
  
  private StringBuilder buildSQLCategoryQuery() {
    StringBuilder queryString = Utils.createSQLQueryByPath(EXO_FAQ_CATEGORY, path, false);
    queryString.append(" AND ").append(EXO_IS_VIEW).append(" = 'true' ");

    if (text != null && text.length() > 0) {
      queryString.append(" AND CONTAINS (., '").append(text).append("')");
    }
    if (name != null && name.length() > 0) {
      queryString.append(" AND CONTAINS (").append(EXO_NAME).append(", '").append(name).append("')");
    }
    if (isModeQuestion != null && isModeQuestion.length() > 0 && !isModeQuestion.equals("AllCategories")) {
      queryString.append(" AND ").append(EXO_IS_MODERATE_QUESTIONS).append(" = '").append(isModeQuestion).append("'");
    }
    if (moderator != null && moderator.length() > 0) {
      queryString.append(" AND CONTAINS (").append(EXO_MODERATORS).append(", '").append(moderator).append("')");
    }

    if (!isAdmin) {
      queryString.append(" AND (").append(EXO_USER_PRIVATE).append(" IS NULL OR ").append(EXO_USER_PRIVATE).append(" = ''");
      if (userMembers != null && !userMembers.isEmpty()) {
        for (String str : userMembers) {
          queryString.append(" OR ").append(EXO_USER_PRIVATE).append(" = '").append(str).append("' OR ")
                     .append(EXO_MODERATORS).append(" = '").append(str).append("'");
        }
      }
      queryString.append(")");
    }

    if (fromDate != null) {
      queryString.append(" AND (").append(EXO_CREATED_DATE).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate)).append("')");
    }
    if (toDate != null) {
      queryString.append(" AND (").append(EXO_CREATED_DATE).append(" <= TIMESTAMP '").append(ISO8601.format(toDate)).append("')");
    }

    return queryString;
  }
  
  private StringBuilder buildSQLQuestionQuery() {
    isQuestionLevelSearch = false;
    isAnswerCommentLevelSearch = false;
    isAnd = false;

    StringBuilder queryString = Utils.createSQLQueryByPath("nt:base", path, false);
    // search on main questions
    StringBuilder propertiesSearch = new StringBuilder("(");
    if (author != null && author.length() > 0) {
      if (isAnd)
        propertiesSearch.append(" AND ");
      propertiesSearch.append("CONTAINS (").append(EXO_AUTHOR).append(", '").append(author).append("')");
      isAnd = true;
    }
    if (email != null && email.length() > 0) {
      if (isAnd)
        propertiesSearch.append(" AND ");
      propertiesSearch.append("CONTAINS (").append(EXO_EMAIL).append(", '").append(email).append("')");
      isAnd = true;
    }
    if (fromDate != null) {
      if (isAnd)
        propertiesSearch.append(" AND ");
      propertiesSearch.append("(").append(EXO_CREATED_DATE).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate))
                      .append("' OR ").append(EXO_DATE_RESPONSE).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate))
                      .append("' OR ").append(EXO_DATE_COMMENT).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate)).append("')");
      isAnd = true;
    }
    if (toDate != null) {
      if (isAnd)
        propertiesSearch.append(" AND ");
      propertiesSearch.append("(").append(EXO_CREATED_DATE).append(" <= TIMESTAMP '").append(ISO8601.format(toDate))
      .append("' OR ").append(EXO_DATE_RESPONSE).append(" <= TIMESTAMP '").append(ISO8601.format(toDate))
      .append("' OR ").append(EXO_DATE_COMMENT).append(" <= TIMESTAMP '").append(ISO8601.format(toDate)).append("')");
      isAnd = true;
    }
    propertiesSearch.append(")");
    if (propertiesSearch.length() > 2 || isSearchOnDefaultLanguage)
      isQuestionLevelSearch = true;

    // search on language questions
    StringBuilder questionLanguageSearch = getQuestionBuilder();

    // search on answers
    StringBuilder answerSearch = getAnswerBuilder();

    // search on comments
    StringBuilder commentSearch = getCommentBuilder();

    // search on category scoping
    StringBuilder searchCategoryScoping = new StringBuilder("(");
    for (String category : getViewingCategories()) {
      if (searchCategoryScoping.length() > 1)
        searchCategoryScoping.append(" OR ");
      searchCategoryScoping.append(EXO_CATEGORY_ID).append(" = '").append(category).append("'");
    }
    searchCategoryScoping.append(")");

    if (isAnd) {
      queryString.append(" AND ").append(propertiesSearch.toString());
    }
    boolean isAdd = false;
    StringBuilder quesAnsComClause = new StringBuilder();
    if (questionLanguageSearch.length() > 0) {
      quesAnsComClause.append(" AND (").append(questionLanguageSearch.toString());
      isAdd = true;
    }

    if (answerSearch.length() > 2) {
      if (isAdd) {
        quesAnsComClause.append(" OR ").append(answerSearch.toString());
      } else {
        quesAnsComClause.append("(").append(answerSearch.toString());
        isAdd = true;
      }
    }

    if (commentSearch.length() > 2) {
      if (isAdd) {
        quesAnsComClause.append(" OR ").append(commentSearch.toString());
      } else {
        quesAnsComClause.append("(").append(commentSearch.toString());
        isAdd = true;
      }
    }

    StringBuilder textSearch = new StringBuilder();

    if (text != null && text.length() > 0) {
      textSearch.append("("); // open block.
      textSearch.append("CONTAINS(., '").append(text).append("')");
      textSearch.append(" AND (").append(EXO_LANGUAGE).append(" = '").append(language).append("'")
                .append(" OR ").append(EXO_COMMENT_LANGUAGE).append(" = '").append(language).append("'")
                .append(" OR ").append(EXO_RESPONSE_LANGUAGE).append(" = '").append(language).append("'").append(")");
      textSearch.append(")"); // close block.
      isLanguageLevelSearch = false;
      isAnswerCommentLevelSearch = false;
      isQuestionLevelSearch = false;
    }

    if (textSearch.length() > 0) {
      if (isAdd) {
        quesAnsComClause.append(" OR ").append(textSearch.toString());
      } else {
        quesAnsComClause.append(" AND (").append(textSearch.toString());
        isAdd = true;
      }
    }
    if (isAdd)
      quesAnsComClause.append(")"); // close question, answer, comment search clause.

    if (quesAnsComClause.length() > 0) {
      if (isAnd) {
        queryString.append(" AND ");
      }
      queryString.append(quesAnsComClause.toString());
    }

    if (!isAnd && !isAdd) { // if all of fields is empty of null, the search will be by language.
      queryString.append("(").append(EXO_LANGUAGE).append(" = '").append(language).append("'")
                 .append(" OR ").append(EXO_COMMENT_LANGUAGE).append(" = '").append(language).append("'")
                 .append(" OR ").append(EXO_RESPONSE_LANGUAGE).append(" = '").append(language).append("'").append(")");
    }

    if (!searchCategoryScoping.toString().equals("()")) {
      if (isAnd || isAdd) {
        queryString.append(" AND ").append(searchCategoryScoping.toString());
      } else {
        queryString.append(searchCategoryScoping.toString());
        isAdd = true;
      }
    }

    // order
    if ("date".equalsIgnoreCase(sort)) {
      queryString.append(" ORDER BY ").append(EXO_CREATED_DATE);
    } else if ("title".equalsIgnoreCase(sort) || CommonUtils.isEmpty(sort)) {
      queryString.append(" ORDER BY ").append(EXO_TITLE);
    } else if("relevancy".equalsIgnoreCase(sort)) {
      queryString.append(" ORDER BY ").append(JCR_SCORE);
    }

    queryString.append(" ").append(order);
    return queryString;
  }
  
  private StringBuilder buildSQLCategoryAndQuestionQuery() {
    StringBuilder queryString = Utils.createSQLQueryByPath("nt:base", path, false);
    if (text != null && text.length() > 0) {
      queryString.append(" AND CONTAINS(., '").append(text).append("')");
    }

    if (!isAdmin) {
      queryString.append(" AND (");
      queryString.append(EXO_IS_APPROVED).append(" IS NULL OR ")
                 .append(EXO_IS_APPROVED).append(" = 'true'");
      if (userId != null && userId.length() > 0) {
        queryString.append(" OR ").append(EXO_AUTHOR).append(" = '").append(userId).append("'");
      }
      queryString.append(" ) ");
    }

    // search on viewing categories
    if (viewingCategories.size() > 0) {
      queryString.append(" AND (");
      int i = 0;
      for (String catId : viewingCategories) {
        if (i > 0)
          queryString.append(" OR ");
        // on questions
        queryString.append(EXO_CATEGORY_ID).append(" = '").append(catId).append("'");
        // on categories
        queryString.append(" OR ").append(EXO_ID).append(" = '").append(catId).append("'");
        queryString.append(" AND (");
        queryString.append(EXO_USER_PRIVATE).append(" = ''");
        // search restricted audience in category
        if (userMembers != null && userMembers.size() > 0) {
          for (String id : userMembers) {
            queryString.append(" OR ").append(EXO_USER_PRIVATE).append(" = '").append(id).append("'");
          }
        }
        queryString.append(" ) ");
        i++;
      }
      queryString.append(")");
    }

    if (fromDate != null) {
      queryString.append(" AND (").append(EXO_CREATED_DATE).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate))
                 .append("' OR ").append(EXO_DATE_RESPONSE).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate))
                 .append("' OR ").append(EXO_DATE_COMMENT).append(" >= TIMESTAMP '").append(ISO8601.format(fromDate)).append("')");
    }
    if (toDate != null) {
      queryString.append(" AND (").append(EXO_CREATED_DATE).append(" <= TIMESTAMP '").append(ISO8601.format(toDate))
                 .append("' OR ").append(EXO_DATE_RESPONSE).append(" <= TIMESTAMP '").append(ISO8601.format(toDate))
                 .append("' OR ").append(EXO_DATE_COMMENT).append(" <= TIMESTAMP '").append(ISO8601.format(toDate)).append("')");
    }
    return queryString;
  }

  /**
  * This method check date time user input interface 
  * Sets the date from to.
  * 
  * @param fromDate the from date
  * @param toDate the to date
  * @param property the property
  * 
  * @return the string
  */

  public void setViewingCategories(List<String> viewingCategories) {
    this.viewingCategories = viewingCategories;
  }

  public List<String> getViewingCategories() {
    return viewingCategories;
  }

  public boolean isQuestionLevelSearch() throws Exception {
    return isQuestionLevelSearch;
  }

  public boolean isAnswerCommentLevelSearch() throws Exception {
    return isAnswerCommentLevelSearch;
  }
  
  public void setAnswerCommentLevelSearch(boolean isAnswerCommentLevelSearch) {
    this.isAnswerCommentLevelSearch = isAnswerCommentLevelSearch;
  }

  public void setSearchOnDefaultLanguage(boolean isSearchOnDefaultLanguage) {
    this.isSearchOnDefaultLanguage = isSearchOnDefaultLanguage;
  }

  public boolean isSearchOnDefaultLanguage() {
    return isSearchOnDefaultLanguage;
  }

  public void setLanguageLevelSearch(boolean isLanguageLevelSearch) {
    this.isLanguageLevelSearch = isLanguageLevelSearch;
  }

  public boolean isLanguageLevelSearch() {
    return isLanguageLevelSearch;
  }

  public boolean isExcerpt() {
    return isExcerpt;
  }

  public void setExcerpt(boolean isExcerpt) {
    this.isExcerpt = isExcerpt;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getComment() {
    return comment;
  }

  public String getAsteriskConditionSearch() {
    return asteriskConditionSearch;
  }

  public void setAsteriskConditionSearch(String asteriskConditionSearch) {
    this.asteriskConditionSearch = asteriskConditionSearch;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }
  
  public abstract StringBuilder getQuestionBuilder();
  
  public abstract StringBuilder getAnswerBuilder();
  
  public abstract StringBuilder getCommentBuilder();
}
