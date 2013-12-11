package org.exoplatform.faq.service.search;

import org.exoplatform.faq.service.FAQEventQuery;

public class UnifiedSearchEventQuery extends FAQEventQuery {

  public StringBuilder getQuestionBuilder() {
    String question = getQuestion();
    String language = getLanguage();
    StringBuilder questionLanguageSearch = new StringBuilder();
    if (question != null && question.length() > 0) {
      questionLanguageSearch.append("(").append(EXO_LANGUAGE).append(" = '").append(language).append("'");
      applyUnifiedSearchCondition(questionLanguageSearch, EXO_TITLE, EXO_NAME);
      questionLanguageSearch.append(")");
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
      //
      answerSearch = applyUnifiedSearchCondition(answerSearch, EXO_RESPONSES);
      
      answerSearch.append(")");
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
      //
      commentSearch = applyUnifiedSearchCondition(commentSearch, EXO_COMMENTS);
      
      commentSearch.append(")");
      setAnswerCommentLevelSearch(true);
    }
    
    return commentSearch;
  }
  
  private StringBuilder applyUnifiedSearchCondition(StringBuilder sb, String... jcrField) {
    //for asterisk condition search
    String searchCondition = getAsteriskConditionSearch().toUpperCase();
    if(searchCondition != null && searchCondition.length() > 0){
      sb.append(" AND (");
      //
      int cpt = 0;
      for (String field : jcrField) {
        if (cpt >= 1) {
          sb.append(" OR ");
        }
        sb.append("UPPER(").append(field).append(") LIKE '").append(searchCondition).append("'");
        cpt++;
      }
      sb.append(")");
    }
    return sb;
  }

}
