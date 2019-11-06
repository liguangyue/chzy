package com.central.user.model;

import com.central.common.model.SysPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * https://github.com/shenzhuan/chzyplus on 2018/9/30.
 */
public class SysPermissionNode extends SysPermission {
    @Getter
    @Setter
    private List<SysPermissionNode> children;
}
