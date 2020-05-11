package com.honyelchak.easypoi.constants;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExcelConstants {

    CODE_IMPORT('1', "导入"),
    CODE_EXPORT('2', "导出");

    Character code;
    String Description;


}
