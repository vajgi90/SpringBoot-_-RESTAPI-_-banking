package hu.flowacademy.demo.service;


import hu.flowacademy.demo.exception.IdValidationException;
import hu.flowacademy.demo.exception.MissingParameterException;
import hu.flowacademy.demo.exception.TooLongException;
import hu.flowacademy.demo.exception.ValidationException;
import hu.flowacademy.demo.persistence.entity.DomesticTransaction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DomesticValidationService {


    private static Object IdValidationException;
    private static Object MissingParameterException;
    private static Object TooLongException;
    private static Object ValidationException;


    public static void createValidator(DomesticTransaction data) throws Throwable {
        String regex = "[0-9]{8}-[0-9]{8}|[0-9]{8}-[0-9]{8}-[0-9]{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data.getHostAccountNumber());
       if(data.getTransactionId() != null) {
            throw new IdValidationException("Létező id");
        }
        if (StringUtils.isEmpty(data.getSenderName())) {
            throw new MissingParameterException("Missing parameter");
        }
        if(data.getHostName().equals(data.getSenderName())) throw new ValidationException("Names are equals");
        if (data.getHostName().length() > 20) throw new TooLongException("Too long");
        if (StringUtils.isEmpty(data.getHostAccountNumber())) throw new MissingParameterException("Missing parameter");
        if (!matcher.matches()) throw new ValidationException("Wrong account number");
        if (data.getHostAccountNumber().length() > 26) throw new TooLongException("Account number is too long.");
        if (data.getAmount() <= 0 || data.getAmount() > Long.parseLong("999999999999"))
            throw new ValidationException("Wrong amount");
    }
    public static void updateValidator(DomesticTransaction data) throws Throwable {
        String regex = "[0-9]{8}-[0-9]{8}|[0-9]{8}-[0-9]{8}-[0-9]{8}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data.getHostAccountNumber());
        if(StringUtils.isEmpty(data.getTransactionId().toString())) {
            throw new IdValidationException("Létező id");
        }
        if (StringUtils.isEmpty(data.getSenderName())) {
            throw new MissingParameterException("Missing parameter");
        }
        if(data.getHostName().equals(data.getSenderName())) throw new ValidationException("Names are equals");
        if (data.getHostName().length() > 20) throw new TooLongException("Too long");
        if (StringUtils.isEmpty(data.getHostAccountNumber())) throw new MissingParameterException("Missing parameter");
        if (!matcher.matches()) throw new ValidationException("Wrong account number");
        if (data.getHostAccountNumber().length() > 26) throw new TooLongException("Account number is too long.");
        if (data.getAmount() <= 0 || data.getAmount() > Long.parseLong("999999999999"))
            throw new ValidationException("Wrong amount");
    }

}
