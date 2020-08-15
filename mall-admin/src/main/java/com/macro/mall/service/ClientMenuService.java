package com.macro.mall.service;

import com.macro.mall.model.ClientMenu;
import java.util.List;

/**
 * 后台菜单管理Service
 * Created by macro on 2020/2/2.
 */
public interface ClientMenuService {
    /**
     * 创建后台菜单
     */
    int create(ClientMenu clientMenu);

    /**
     * 修改后台菜单
     */
    int update(Long id, ClientMenu clientMenu);

    /**
     * 根据ID获取菜单详情
     */
    ClientMenu getItem(Long id);

    /**
     * 根据ID删除菜单
     */
    int delete(Long id);

    /**
     * 分页查询后台菜单
     */
    List<ClientMenu> list(Long parentId, Integer pageSize, Integer pageNum);

    /**
     * 树形结构返回所有菜单列表
     */
    List<ClientMenu> treeList();

    /**
     * 修改菜单显示状态
     */
    int updateHidden(Long id, Integer hidden);
}
