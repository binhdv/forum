package org.exoplatform.faq.service;

import org.exoplatform.forum.common.CommonUtils;

public class FAQSearchEventQuery extends FAQEventQuery {

  public StringBuilder getQuestionBuilder() {
    String question = getQuestion();
    String language = getLanguage();
    StringBuilder questionLanguageSearch = new StringBuilder();
    if (question != null && question.length() > 0) {
      questionLanguageSearch.append("(").append(EXO_LANGUAGE).append(" = '").append(language).append("'");
      questionLanguageSearch.append(" AND (CONTAINS (").append(EXO_TITLE).append(", '").append(question).append("')")
                            .append(" OR CONTAINS (").append(EXO_NAME).append(", '").append(question).append("')");
      //
      questionLanguageSearch.append("))");
      if (isSearchOnDefaultLanguage())
        setLanguageLevelSearch(false);
      else
        setLanguageLevelSearch(true);
    }
    return questionLanguageSearch;
  }
  
  public StringBuilder getAnswerBuilder() {
    String response = getResponse();
    String language = getLanguage();
    StringBuilder answerSearch = new StringBuilder("");
    if (response != null && response.length() > 0) {
      answerSearch.append("(").append(EXO_RESPONSE_LANGUAGE).append(" = '").append(language).append("'");
      if(response.contains(CommonUtils.PERCENT_STR)){
        answerSearch.append(" AND (").append(EXO_RESPONSES).append(" LIKE '").append(response).append("'");
      }else {
        answerSearch.append(" AND ( CONTAINS(").append(EXO_RESPONSES).append(",'").append(response).append("')");
      }
      //
      answerSearch.append("))");
      setAnswerCommentLevelSearch(true);
    }
    
    return answerSearch;
  }
  
  public StringBuilder getCommentBuilder() {
    String comment = getComment();
    String language = getLanguage();
    StringBuilder commentSearch = new StringBuilder();
    if (comment != null && comment.length() > 0) {
      commentSearch.append("(").append(EXO_COMMENT_LANGUAGE).append(" = '").append(language).append("'");
      if(comment.contains(CommonUtils.PERCENT_STR)){
        commentSearch.append(" AND (").append(EXO_COMMENTS).append(" LIKE '").append(comment).append("'");
      }else {
        commentSearch.append(" AND ( CONTAINS(").append(EXO_COMMENTS).append(",'").append(comment).append("')");
      }
      //
      commentSearch.append("))");
      setAnswerCommentLevelSearch(true);
    }
    
    return commentSearch;
  }
  
}
