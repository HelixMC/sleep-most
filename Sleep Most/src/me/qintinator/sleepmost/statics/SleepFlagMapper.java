package me.qintinator.sleepmost.statics;

import me.qintinator.sleepmost.flags.*;
import me.qintinator.sleepmost.interfaces.ISleepFlag;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class SleepFlagMapper {

    public static SleepFlagMapper mapper;
    private HashMap<String, ISleepFlag> allFlags = new HashMap<>();


    private SleepFlagMapper() {
        allFlags.put("percentage-required", new PercentageRequiredFlag());
        allFlags.put("mob-no-target", new MobNoTargetFlag());
        allFlags.put("use-exempt", new UseExemptFlag());
        allFlags.put("prevent-sleep", new PreventSleepFlag());
        allFlags.put("prevent-phantom", new PreventPhantomFlag());
        allFlags.put("nightcycle-animation", new NightcycleAnimationFlag());
        allFlags.put("storm-sleep", new StormSleepFlag());
    }

    public static SleepFlagMapper getMapper(){
        if(mapper == null)
            mapper = new SleepFlagMapper();
        return mapper;
    }

    public ISleepFlag getFlag(String flag){
        return allFlags.get(flag);
    }

    public boolean flagExists(String flag){
        return allFlags.containsKey(flag);
    }

    public List<String> getAllFlags(){
        return this.allFlags.keySet().stream().collect(Collectors.toList());
    }
}
