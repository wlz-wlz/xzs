package cn.com.wlz.xzs.domain.other;

import lombok.Data;

@Data
public class ExamPaperAnswerUpdate {
    private Integer id;
    private Integer customerScore;
    private Boolean doRight;
}
