package jpower.core;

import jpower.core.utils.IOUtils;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class JPower
{

    private static final Release release;

    static
    {
        String rawRelease = IOUtils.getResourceAsString(JPower.class, "release.properties");
        Pattern pattern = Pattern.compile("(.*)=(.*)");
        Matcher matcher = pattern.matcher(rawRelease);
        Map<String, String> info = new HashMap<>();
        while (matcher.find())
        {
            info.put(matcher.group(1), matcher.group(2));
        }
        release = new Release(info);
    }

    public static Release getReleaseInfo()
    {
        return release;
    }

    public static class Release
    {

        private final String version;
        private final String commit;

        public Release(Map<String, String> info)
        {
            version = info.get("version");
            commit = info.get("commit");
        }

        public String getVersion()
        {
            return version;
        }

        public String getCommit()
        {
            return commit;
        }

    }

}
