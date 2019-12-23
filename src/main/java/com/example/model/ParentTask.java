package com.example.model;

import javax.persistence.*;

@Entity
@Table(name="parentTask")
public class ParentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="parent_id")
    private Integer parentTaskId;

    @Column(name="parent_task")
    private String parentTaskName;

    public Integer getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(Integer parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getParentTaskName() {
        return parentTaskName;
    }

    public void setParentTaskName(String parentTaskName) {
        this.parentTaskName = parentTaskName;
    }
}
