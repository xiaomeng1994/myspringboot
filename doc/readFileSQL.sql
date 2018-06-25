CREATE TABLE `sys_dir_file`  (
  `DIR_FILE_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DEP_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门ID',
  `FILE_NAME_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `PARENT_` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级目录',
  `DOC_DIR_TYPE_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件或目录类型\r\n            FILE=文件\r\n            DIR=目录',
  `DOC_EXT_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文档后缀',
  `REL_PATH_` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '相对路径',
  `FILE_SIZE_` bigint(20) NULL DEFAULT NULL COMMENT '字节大小'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '目录文件' ROW_FORMAT = Compact;
