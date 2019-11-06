package com.chzyplus.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chzyplus.member.entity.UmsMember;
import com.chzyplus.member.entity.UmsMemberReceiveAddress;
import com.chzyplus.member.mapper.UmsMemberReceiveAddressMapper;
import com.chzyplus.member.service.IUmsMemberReceiveAddressService;
import com.chzyplus.member.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 会员收货地址表 服务实现类
 * </p>
 *
 * @author zscat
 * @since 2019-04-19
 */
@Service
public class UmsMemberReceiveAddressServiceImpl extends ServiceImpl<UmsMemberReceiveAddressMapper, UmsMemberReceiveAddress> implements IUmsMemberReceiveAddressService {

    @Resource
    private UmsMemberReceiveAddressMapper addressMapper;
    @Override
    public UmsMemberReceiveAddress getDefaultItem() {

        UmsMember currentMember = UserUtils.getCurrentMember();
        UmsMemberReceiveAddress q = new UmsMemberReceiveAddress();
        q.setDefaultStatus(1);
        q.setMemberId(currentMember.getId());
        return this.getOne(new QueryWrapper<>(q));
    }

    @Transactional
    @Override
    public int setDefault(Long id) {
        UmsMember currentMember = UserUtils.getCurrentMember();
        addressMapper.updateStatusByMember(currentMember.getId());

        UmsMemberReceiveAddress def = new UmsMemberReceiveAddress();
        def.setId(id);
        def.setDefaultStatus(1);
        this.updateById(def);
        return 1;
    }
}
