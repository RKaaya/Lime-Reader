package com.rkaaya.limereader.services;

import com.rkaaya.lime.domain.model.Lime;
import com.rkaaya.limereader.api.LimeEntityMapper;
import com.rkaaya.limereader.services.dao.entity.LimeEntity;
import com.rkaaya.limereader.services.dao.repository.LimeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DefaultLimeReaderServiceTest {

    @Mock
    private LimeEntityMapper limeEntityMapper;
    @Mock
    private LimeRepository limeRepository;

    @InjectMocks
    private DefaultLimeReaderService limeReaderService;

    @Test
    void getLastTenComputate() {
        List<LimeEntity> limeEntities = new ArrayList<>();
        LimeEntity limeEntity = LimeEntity.builder()
                .freqWord("asd").build();
        limeEntities.add(limeEntity);

        Lime lime = Mockito.mock(Lime.class);

        Mockito.when(limeRepository.findTop10ByOrderByMessageCreatedDesc()).thenReturn(limeEntities);
        Mockito.when(limeEntityMapper.mapEntityToLime(limeEntity)).thenReturn(lime);

        Assertions.assertEquals(true, limeReaderService.getLastTenComputate().contains(lime));
    }

    @Test
    void saveLimeMessage() {
        final Lime lime = Mockito.mock(Lime.class);
        final Long createdTime = 1L;
        final LimeEntity limeEntity = Mockito.mock(LimeEntity.class);

        Mockito.when(limeEntityMapper.mapLimeToEntity(lime, createdTime)).thenReturn(limeEntity);
        limeReaderService.saveLimeMessage(lime, createdTime);
        verify(limeRepository, times(1)).save(limeEntity);
    }
}