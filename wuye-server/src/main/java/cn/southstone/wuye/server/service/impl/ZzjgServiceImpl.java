package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.server.dao.ZzjgDao;
import cn.southstone.wuye.common.dto.ZzjgDto;
import cn.southstone.wuye.server.domain.Zzjg;
import cn.southstone.wuye.server.service.ZzjgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("zzjgService")
@Transactional
public class ZzjgServiceImpl implements ZzjgService {
    @Autowired
    ZzjgDao zzjgDao;

    public ZzjgDto findRoot() {
        Zzjg zzjg =zzjgDao.findById(1L);
        ZzjgDto zzjgDto=null;
        if (null != zzjg) {
            zzjgDto = transferToDto(zzjg);
        }
        return zzjgDto;
    }

    private ZzjgDto transferToDto(Zzjg zzjg) {
        ZzjgDto zzjgDto=new ZzjgDto();
        zzjgDto.setId(zzjg.getId());
        if (null != zzjg.getParent()) {
            zzjgDto.setParentId(zzjg.getParent().getId());

        }

        zzjgDto.setName(zzjg.getName());
        zzjgDto.setJglb(zzjg.getJglb());
        zzjgDto.setDescription(zzjg.getDescription());

        for (Zzjg child : zzjg.getChildren()) {
            ZzjgDto childDto = transferToDto(child);
            zzjgDto.addChild(childDto);
        }
        return zzjgDto;
    }
}
