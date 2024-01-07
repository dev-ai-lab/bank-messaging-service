package com.bank.bankmessagingservice.functions;

import com.bank.bankmessagingservice.dto.AccountsMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunction {

    private static final Logger log = LoggerFactory.getLogger(MessageFunction.class);
    @Bean
    public Function<AccountsMessageDto, AccountsMessageDto> email() {
        return (accountMessageDto) -> {
            log.info("Sending Email with the details: {}", accountMessageDto.toString());
            return accountMessageDto;
        };
    }

    @Bean
    public Function<AccountsMessageDto, Long> sms() {
        return (accountMessageDto) -> {
            log.info("Sending SMS with the details: {}", accountMessageDto.toString());
            return accountMessageDto.accountNumber();
        };
    }
}
