package com.app.startNstop.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by gor on 09/10/2016.
 */

@DatabaseTable(tableName = "projects_table")
public class ProjectsTable {
    @DatabaseField(generatedId = true, columnName = "_id")
    private Long id;

    @DatabaseField
    private String name;
}
