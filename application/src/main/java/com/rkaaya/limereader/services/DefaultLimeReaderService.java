package com.rkaaya.limereader.services;

import com.rkaaya.lime.domain.model.Lime;
import com.rkaaya.limereader.api.LimeEntityMapper;
import com.rkaaya.limereader.api.LimeReaderService;
import com.rkaaya.limereader.services.dao.entity.LimeEntity;
import com.rkaaya.limereader.services.dao.repository.LimeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Slf4j
public class DefaultLimeReaderService implements LimeReaderService {

    private LimeEntityMapper limeEntityMapper;
    private LimeRepository limeRepository;

    @Override
    public List<Lime> getLastTenComputate() {
        List<LimeEntity> limeEntities = limeRepository.findTop10ByOrderByMessageCreatedDesc();
        log.info("Found limes in db: {}", limeEntities.size());
        return limeEntities.stream().map(item -> limeEntityMapper.mapEntityToLime(item)).collect(Collectors.toList());
    }

    @Override
    public void saveLimeMessage(final Lime lime, final Long createdTime) {
        LimeEntity limeEntity = limeEntityMapper.mapLimeToEntity(lime, createdTime);
        limeRepository.save(limeEntity);
        log.info("Saved: {}", limeEntity);
    }
}
