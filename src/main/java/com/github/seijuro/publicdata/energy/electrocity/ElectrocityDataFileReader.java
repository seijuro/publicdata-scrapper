package com.github.seijuro.publicdata.energy.electrocity;

import com.github.seijuro.common.io.BufferedFileReader;
import com.github.seijuro.publicdata.result.item.TheUseOfElectrocityData;
import lombok.Getter;

public class ElectrocityDataFileReader extends BufferedFileReader {
    @Getter
    static final String DefaultCharsetName = "EUC-KR";

    public ElectrocityDataFileReader(String filepath) {
        this(filepath, getDefaultCharsetName());
    }

    public ElectrocityDataFileReader(String filepath, String charsetName) {
        super(filepath, charsetName);
    }

    public TheUseOfElectrocityData readData() throws Exception {
        String line = super.readLine();

        if (line == null) {
            return null;
        }

        return parse(line);
    }

    public TheUseOfElectrocityData parse(String line) {
        String[] tokens = line.split("\\|");

        String dateYM = tokens[0];
        String address = tokens[1];
        String addressRoad = tokens[2];
        String addressCode_DGSGGU = tokens[3];
        String addressCode_EMD = tokens[4];
        String landType = tokens[5];
        String addressCode_JibunMajor = tokens[6];
        String addressCode_JibunMinor = tokens[7];
        String rnum = tokens[8];
        String addressCode_Road = tokens[9];
        String addressCode_GroudType = tokens[10];
        String addressCode_BunMajor = tokens[11];
        String addressCode_BunMinor = tokens[12];
        String useQuantity = tokens[13];

        TheUseOfElectrocityData.Builder dataBuilder = new TheUseOfElectrocityData.Builder();
        dataBuilder.setUseYM(dateYM);
        dataBuilder.setAddress(address);
        dataBuilder.setAddressRoad(addressRoad);
        dataBuilder.setAddressCodeDGSGGU(addressCode_DGSGGU);
        dataBuilder.setAddressCodeEMD(addressCode_EMD);
        dataBuilder.setTypeCodeLand(landType);
        dataBuilder.setAddressCodeJibunMajor(addressCode_JibunMajor);
        dataBuilder.setAddressCodeJibunMinor(addressCode_JibunMinor);
        dataBuilder.setRecordNumber(rnum);
        dataBuilder.setAddressCodeRoad(addressCode_Road);
        dataBuilder.setTypeCodeGround(addressCode_GroudType);
        dataBuilder.setAddressNumberMajor(addressCode_BunMajor);
        dataBuilder.setAddressNumberMinor(addressCode_BunMinor);
        dataBuilder.setUseQuantity(useQuantity);

        return dataBuilder.build();
    }
}
