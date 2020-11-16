package my.project.version;

import lombok.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Optional.ofNullable;

public class VersionFactory {

    private static final Pattern SEMANTIC_VERSION_PATTERN = Pattern.compile("(?<major>\\d+)(?:\\.(?<minor>\\d+)(?:\\.(?<patch>\\d+))?)?");
    private static final Pattern HAS_LEADING_ZEROS_PATTERN = Pattern.compile("^0\\d+");

    public SemanticVersion buildSemanticVersion(@NonNull String string) {
        Matcher matcher = SEMANTIC_VERSION_PATTERN.matcher(string);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Version format is incorrect.");
        }

        int major = toInt(matcher.group("major"));
        int minor = toIntOrZero(matcher, "minor");
        int patch = toIntOrZero(matcher, "patch");

        return new SemanticVersion(major, minor, patch);
    }

    private Integer toIntOrZero(Matcher matcher, String string) {
        return ofNullable(matcher.group(string))
                .map(this::toInt)
                .orElse(0);
    }

    private int toInt(String version) {
        if (HAS_LEADING_ZEROS_PATTERN.matcher(version).matches()) {
            throw new IllegalArgumentException("Version cannot have leading zeros.");
        }
        return Integer.parseInt(version);
    }

}
