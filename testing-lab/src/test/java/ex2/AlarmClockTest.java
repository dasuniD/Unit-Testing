package ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.platform.commons.util.ReflectionUtils;

class AlarmClockTest{
    @Test
	@DisplayName("Test tick method")
	void verifyClock() {
		Clock clock = new Clock();
        clock.setTime(23,59,0);
        for(int i =0;i<60;i++){
            clock.tick();
        }
        assertEquals(0,clock.hour, "After 24 hours, hour should reset back to 0");
        assertEquals(0,clock.minute, "After 24 hours, minute should reset back to 0");
        assertEquals(0,clock.second, "After 24 hours, second should reset back to 0");
	}

    @Test
	@DisplayName("test alarmRing")
	void verifyAlarm() {
		AlarmClock alarm = new AlarmClock();
        alarm.setTime(07,25,0);
        alarm.setAlarmTime(07,26);
        for(int i =0;i<60;i++){
            alarm.tick();
        }
        assertEquals(true,alarm.alarmRinging, "alarmRinging should be true");
        for(int i =0;i<60;i++){
            alarm.tick();
        }
        assertEquals(false,alarm.alarmRinging, "After a minute alarmRinging should be false");
	}


}
