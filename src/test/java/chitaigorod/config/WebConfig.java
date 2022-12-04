package chitaigorod.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/${tag}/${env}.properties"
})
public interface WebConfig extends Config {

    String browserName();

    String browserSize();

    String remoteUrl();

    String videoStorage();

    String baseUrl();

    Boolean isRemote();
}