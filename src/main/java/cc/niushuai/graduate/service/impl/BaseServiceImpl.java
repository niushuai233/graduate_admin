package cc.niushuai.graduate.service.impl;

import cc.niushuai.graduate.commons.utils.ShiroUtils;
import cc.niushuai.graduate.entity.admin.SysUser;
import cc.niushuai.graduate.service.BaseService;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

import static cc.niushuai.graduate.commons.constant.Constant.*;

@Slf4j
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    /**
     * 通用注入创建 更新信息 可通过super调用
     *
     * @param record
     * @param flag
     * @return
     */
    @Override
    public T addValue(T record, boolean flag, int saveOrUpdate) {
        //统一处理公共字段
        Class<?> clazz = record.getClass();
        String operator, operateDate;
        Field[] declaredFields = clazz.getDeclaredFields();
        try {
            // tian
            if (flag) {
                //添加 id uuid支持
                Field idField = clazz.getDeclaredField(ID);
                idField.setAccessible(true);
                Object o = idField.get(record);
                Class<?> type = idField.getType();
                String name = type.getName();
                if ((o == null) && STRING_TYPE.equals(name)) {
                    //已经有值的情况下 不覆盖
                    idField.set(record, UUID.randomUUID().toString().replace("-", "").toUpperCase());
                }

            }

            if (0 == saveOrUpdate) {
                operator = CREATE_BY;
                operateDate = checkCreateDate(declaredFields);
            } else if (1 == saveOrUpdate) {
                operator = UPDATE_BY;
                operateDate = checkUpdateDate(declaredFields);
            } else {
                return record;
            }

            SysUser loginUser = ShiroUtils.getUserEntity();
            if (null != loginUser) {
                try {
                    if (null != operator) {
                        Field field = clazz.getDeclaredField(operator);
                        field.setAccessible(true);
                        field.set(record, loginUser.getUsername());
                    }
                } catch (Exception e) {
                    log.error("exception happen {}", e.getMessage());
                }
                // 上一个出现异常  不影响下一个
                try {
                    if (null != operateDate) {
                        Field fieldDate = clazz.getDeclaredField(operateDate);
                        fieldDate.setAccessible(true);
                        fieldDate.set(record, new Date());
                    }
                } catch (Exception e) {
                    log.error("exception happen {}", e.getMessage());
                }
            }

        } catch (NoSuchFieldException e) {
            //无此字段
            log.error("该字段不存在：{}", e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("访问权限异常", e.getMessage());
        }
        return record;
    }

    protected String checkCreateDate(Field[] declaredFields) {
        for (Field field : declaredFields) {
            String fieldName = field.getName();
            if (fieldName.equals(CREATE_DATE)) {
                return CREATE_DATE;
            } else if (fieldName.equalsIgnoreCase(CREATE_TIME)) {
                return CREATE_TIME;
            }
        }
        return null;
    }

    protected String checkUpdateDate(Field[] declaredFields) {
        for (Field field : declaredFields) {
            String fieldName = field.getName();
            if (fieldName.equals(UPDATE_DATE)) {
                return UPDATE_DATE;
            } else if (fieldName.equalsIgnoreCase(UPDATE_TIME)) {
                return UPDATE_TIME;
            }
        }
        return null;
    }
}
