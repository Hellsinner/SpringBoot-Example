package com.yanghan.web.commpent;

import com.yanghan.web.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by yanghan on 2019-10-01.
 */
@Component
public class UserVailder implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (o == null) {
            throw new RuntimeException("param is null");
        }

        User user = (User) o;

        if (StringUtils.isEmpty(user.getName()) || user.getAge() < 0) {
            throw new RuntimeException("param is invaild");
        }
    }
}
