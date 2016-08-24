package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.BzxyDto;
import cn.southstone.wuye.common.dto.CalResultDto;
import cn.southstone.wuye.server.domain.Bzxy;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
public interface BzxyService {

     BzxyDto findById(Long id);

     List<BzxyDto> findAllBzxyDtos();

     List<BzxyDto> findBzxiesByFkgxId(Long id);

     List<BzxyDto> findBzxiesBySfbzId(Long id);

     List<BzxyDto> findBzxiesBySfxmId(Long id);

    List<CalResultDto> calculateBySfxmId(Long id);

    BzxyDto transferToDto(Bzxy bzxy);

    List<BzxyDto> findBzxiesByDyqyId(Long id);

    List<BzxyDto> findBzxiesByWyzyId(Long id);

}
