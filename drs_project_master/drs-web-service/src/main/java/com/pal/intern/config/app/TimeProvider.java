package com.pal.intern.config.app;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TimeProvider {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * get system time zone
     *
     * @return
     */
    public TimeZone getcurrentTimeZone() {
        ZoneId zoneId = ZoneId.systemDefault();
        return TimeZone.getTimeZone(zoneId);

    }

    /**
     * get time zone in GMT
     *
     * @param timeZone
     * @return String time zone ex(+7:00)
     */
    public String getTimeZoneInGMT(TimeZone timeZone) {
        long hours = TimeUnit.MILLISECONDS.toHours(timeZone.getRawOffset());

        StringBuilder result = new StringBuilder();
        if (hours > 0) {
            result.append("+").append(hours).append(":00");
        } else {
            result.append("-").append(hours).append(":00");
        }
        return result.toString();
    }

    public String getDatabaseTimeZone() {
        String sql = "SELECT @@global.time_zone as tz";
        String result = null;
        try {
            result = this.jdbcTemplate.query(sql, (rs) -> {
                String timeZome = null;
                while (rs.next()) {
                    timeZome = rs.getString("tz");
                }
                return timeZome;
            });

        } catch (DataAccessException e) {
            LOGGER.error("Error when call getDatabaseTimeZone()", e);
        }
        return result;
    }

    /**
     *
     * @param dateTime String dateTime with format 2018-03-20 03:19:19
     * @param from time zone covert from example +7:00
     * @param to time zone covert from example -4:00
     * @return String dateTime or null
     */
    public String convertDateTimeWithTimeZone(String dateTime, String from, String to) {
        String result = null;
        String sql = "SELECT CONVERT_TZ(?,?,?) as dt";
        Object[] params = {dateTime, from, to};
        try {

            result = this.jdbcTemplate.query(sql, params, (rs) -> {
                String queryResult = null;
                while (rs.next()) {
                    queryResult = rs.getString("dt");
                }
                return queryResult;
            });
        } catch (DataAccessException e) {
            LOGGER.error("Error when call method convertDateTimeWithTimeZone() with param " + Arrays.asList(dateTime, from, to), e);
        }
        return result;
    }

    public LocalDateTime getLocalDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }

    public String convertDateTimeFromDBTimeZoneToSystemTimeZone(String dateTime) {
        String dbTimeZone = getDatabaseTimeZone();
        String systemTimeZone = getTimeZoneInGMT(getcurrentTimeZone());
        return convertDateTimeWithTimeZone(dateTime, dbTimeZone, systemTimeZone);
    }

    public String getToDay() {
        LocalDate date = LocalDate.now();
        return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public boolean isDateBetween(LocalDateTime dateCheck, LocalDateTime startDate, LocalDateTime endDate) {
        Duration.between(startDate, endDate);
        return (dateCheck.isAfter(startDate) || dateCheck.equals(startDate)) && (dateCheck.isBefore(endDate) || dateCheck.equals(endDate));

    }

    public String getLocalDateTimeWithZuluFormat(LocalDateTime localDateTime) {
        DateTime dateTime = new DateTime(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())).withZone(DateTimeZone.UTC);
        String dateTimeFormatter = dateTime.toString("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return dateTimeFormatter;
    }
}
