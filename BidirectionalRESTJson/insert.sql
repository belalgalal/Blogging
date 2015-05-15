INSERT INTO `bidirectional_schema`.`parent` (`PARENT_ID`, `PARENT_CONTENT`) VALUES ('1', 'First Parent');

INSERT INTO `bidirectional_schema`.`child` (`CHILD_ID`, `CHILD_CONTENT`, `PARENT_PARENT_ID`) VALUES ('1', 'First Child', '1');

INSERT INTO `bidirectional_schema`.`child` (`CHILD_ID`, `CHILD_CONTENT`, `PARENT_PARENT_ID`) VALUES ('2', 'Second Child', '1');
