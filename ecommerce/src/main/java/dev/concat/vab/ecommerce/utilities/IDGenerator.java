package dev.concat.vab.ecommerce.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

public class IDGenerator {
    private final static Logger LOG = LoggerFactory.getLogger(IDGenerator.class);
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghjklmnopqrstuvwxyz";
    private static final int ID_LENGTH = 10;

    public static String generateRandomID(){
        StringBuilder idBuilder = new StringBuilder();
        Random random = new Random();
        StringBuilder value = null;
        for(int i = 0; i < ID_LENGTH; ++i){
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            value = idBuilder.append(randomChar);
            LOG.info("[  : "+value +" ]");
        }
        return value.toString();
    }
}
