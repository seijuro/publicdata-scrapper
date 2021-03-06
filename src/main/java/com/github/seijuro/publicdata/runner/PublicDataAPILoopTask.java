package com.github.seijuro.publicdata.runner;

import com.github.seijuro.publicdata.PublicDataAPIException;
import com.github.seijuro.publicdata.PublicDataAPIServices;
import com.github.seijuro.publicdata.api.PublicDataAPI;
import com.github.seijuro.publicdata.result.PublicDataAPIErrorResult;
import com.github.seijuro.publicdata.result.PublicDataAPIResult;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class PublicDataAPILoopTask extends PublicDataAPITask {
    /**
     * C'tor
     *
     * @param apiService
     */
    public PublicDataAPILoopTask(PublicDataAPIServices apiService) throws PublicDataAPIException {
        super(apiService);
    }

    @Override
    public void run() {
        try {
            do {
                handleLoop();
            } while (runningState == RunningState.RUNNING);
        }
        catch (InterruptedException excp) {
            excp.printStackTrace();
        }

        log.info("terminating task-loop ...");
    }
}
