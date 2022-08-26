package org.csystem.app.randomuser.collector.data.entity;


import org.csystem.app.randomuser.collector.dto.Info;
import org.csystem.app.randomuser.collector.dto.Result;

import java.io.Serializable;
import java.util.List;


public class UserInfo implements Serializable {
    private static final long serialVersionID = 1L;
    public List<Result> results;
    public Info info;
}
