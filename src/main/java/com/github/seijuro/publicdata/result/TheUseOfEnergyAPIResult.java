package com.github.seijuro.publicdata.result;

public class TheUseOfEnergyAPIResult extends PublicDataAPIResult {
    /**
     * C'tor
     *
     * @param $resultCode
     * @param $resultMesg
     * @param $pageNo
     * @param $numOfRows
     * @param $totalCount
     */
    public TheUseOfEnergyAPIResult(String $resultCode, String $resultMesg, Integer $pageNo, Integer $numOfRows, Integer $totalCount) {
        super($resultCode, $resultMesg, $pageNo, $numOfRows, $totalCount);
    }

    /**
     * C'tor
     *
     * @param parent
     * @param <T>
     */
    public <T extends PublicDataAPIResult> TheUseOfEnergyAPIResult(T parent) {
        super(parent.getResultCode(), parent.getResultMessage(), parent.getPageNo(), parent.getNumberOfRows(), parent.getTotalCount());
    }
}
