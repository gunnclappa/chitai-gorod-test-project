package chitaigorod.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/${tag}/${env}.properties"
})
public interface MobileConfig extends Config {

    String browserstackUser();

    String browserstackKey();

    String device();

    String osVersion();

    String project();

    String build();

    String name();

    String platformName();

    String appPackage();

    String appActivity();

    String remoteUrl();
}
