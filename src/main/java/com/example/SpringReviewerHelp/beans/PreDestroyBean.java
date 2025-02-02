package com.example.SpringReviewerHelp.beans;

import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Getter
@Setter
public class PreDestroyBean {
    private String favoriteGame = "The Punisher 2005";
    private String favoriteMovie = "Wanted";

    public PreDestroyBean() {
    }

    /**
     * Check this in logs when the controller endpoint is hit.
     */
    @PreDestroy
    public void cleanUp() {
        log.info("Bean is being destroyed:{}", this.getClass(). getName());
    }
}
