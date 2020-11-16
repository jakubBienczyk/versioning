package my.project.version;

import lombok.NonNull;
import lombok.Value;

import java.util.Comparator;

@Value
public class SemanticVersion implements Comparable<SemanticVersion> {

    private final static Comparator<SemanticVersion> COMPARATOR = Comparator.comparingInt(SemanticVersion::getMajor)
            .thenComparingInt(SemanticVersion::getMinor)
            .thenComparingInt(SemanticVersion::getPatch);

    int major;
    int minor;
    int patch;

    public SemanticVersion(int major, int minor, int patch) {
        if (major < 0 || minor < 0 || patch < 0) {
            throw new IllegalArgumentException("Major, minor and patch must be non-negative");
        }

        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    @Override
    public int compareTo(@NonNull SemanticVersion semanticVersion) {
        return COMPARATOR.compare(this, semanticVersion);
    }

    public boolean isGreaterThan(@NonNull SemanticVersion version) {
        return compareTo(version) > 0;
    }

    public boolean isGreaterThanOrEqualTo(@NonNull SemanticVersion version) {
        return compareTo(version) >= 0;
    }

    public boolean isLessThan(@NonNull SemanticVersion version) {
        return compareTo(version) < 0;
    }

    public boolean isLessThanOrEqualTo(@NonNull SemanticVersion version) {
        return compareTo(version) <= 0;
    }

    public boolean isEqualTo(@NonNull SemanticVersion version) {
        return compareTo(version) == 0;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", major, minor, patch);
    }
}
