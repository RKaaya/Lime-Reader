package com.rkaaya.limereader.configuration;

import com.rkaaya.limereader.api.LimeEntityMapper;
import com.rkaaya.limereader.api.LimeReaderService;
import com.rkaaya.limereader.services.DefaultLimeReaderService;
import com.rkaaya.limereader.services.dao.repository.LimeRepository;
import com.rkaaya.limereader.services.mapper.DefaultLimeEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LimeReaderConfiguration {

    @Bean
    LimeReaderService limeReaderService(final LimeRepository limeRepository) {
        return new DefaultLimeReaderService(limeEntityMapper(), limeRepository);
    }

    @Bean
    LimeEntityMapper limeEntityMapper() {
        return new DefaultLimeEntityMapper();
    }

}
