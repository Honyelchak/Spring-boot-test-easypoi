package com.honyelchak.easypoi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * (DataDetail)实体类
 *
 * @author yuejinzhao
 * @since 2020-05-11 18:31:37
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DataDetail implements Serializable {
    private static final long serialVersionUID = 746091646155246795L;

    @Id
    private Integer id;

    @Excel(name = "中文标题", width = 40)
    private String titleCn;

    @Excel(name = "英文标题", width = 40)
    private String titleEn;

    @Excel(name = "作者", width = 20)
    private String author;

    @Excel(name = "组织", width = 20)
    private String organization;

    @Excel(name = "中文摘要", width = 100)
    private String textCn;

    @Excel(name = "英文摘要", width = 100)
    private String textEn;

    @Excel(name = "中文关键字", width = 20)
    private String keywordCn;

    @Excel(name = "英文关键字", width = 20)
    private String keywordEn;

}