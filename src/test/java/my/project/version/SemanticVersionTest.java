package my.project.version;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SemanticVersionTest {

    @Test
    public void whenComparedToVersionWithGreaterMajorVersionShouldReturnNegativeInteger() {
        // given
        SemanticVersion version1 = new SemanticVersion(1, 3, 3);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isLessThan(0);

        assertThat(version1.isLessThan(version2)).isTrue();
        assertThat(version1.isLessThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isGreaterThan(version2)).isFalse();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isFalse();

        assertThat(version1.isEqualTo(version2)).isFalse();
    }

    @Test
    public void whenComparedToVersionWithSmallerMajorVersionShouldReturnPositiveInteger() {
        // given
        SemanticVersion version1 = new SemanticVersion(3, 3, 3);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isGreaterThan(0);

        assertThat(version1.isLessThan(version2)).isFalse();
        assertThat(version1.isLessThanOrEqualTo(version2)).isFalse();

        assertThat(version1.isGreaterThan(version2)).isTrue();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isEqualTo(version2)).isFalse();
    }

    @Test
    public void whenComparedToVersionWithGreaterMinorVersionShouldReturnNegativeInteger() {
        // given
        SemanticVersion version1 = new SemanticVersion(2, 3, 3);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isLessThan(0);

        assertThat(version1.isLessThan(version2)).isTrue();
        assertThat(version1.isLessThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isGreaterThan(version2)).isFalse();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isFalse();

        assertThat(version1.isEqualTo(version2)).isFalse();
    }

    @Test
    public void whenComparedToVersionWithSmallerMinorVersionShouldReturnPositiveInteger() {
        // given
        SemanticVersion version1 = new SemanticVersion(2, 9, 3);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isGreaterThan(0);

        assertThat(version1.isLessThan(version2)).isFalse();
        assertThat(version1.isLessThanOrEqualTo(version2)).isFalse();

        assertThat(version1.isGreaterThan(version2)).isTrue();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isEqualTo(version2)).isFalse();
    }

    @Test
    public void whenComparedToVersionWithGreaterPatchVersionShouldReturnNegativeInteger() {
        // given
        SemanticVersion version1 = new SemanticVersion(2, 6, 3);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isLessThan(0);

        assertThat(version1.isLessThan(version2)).isTrue();
        assertThat(version1.isLessThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isGreaterThan(version2)).isFalse();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isFalse();

        assertThat(version1.isEqualTo(version2)).isFalse();
    }

    @Test
    public void whenComparedToVersionWithSmallerPatchVersionShouldReturnPositiveInteger() {
        // given
        SemanticVersion version1 = new SemanticVersion(2, 6, 9);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isGreaterThan(0);

        assertThat(version1.isLessThan(version2)).isFalse();
        assertThat(version1.isLessThanOrEqualTo(version2)).isFalse();

        assertThat(version1.isGreaterThan(version2)).isTrue();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isEqualTo(version2)).isFalse();
    }

    @Test
    public void whenComparedToTheSameVersionShouldReturnZero() {
        // given
        SemanticVersion version1 = new SemanticVersion(2, 6, 6);
        SemanticVersion version2 = new SemanticVersion(2, 6, 6);

        // when
        int comparison = version1.compareTo(version2);

        // then
        assertThat(comparison).isEqualTo(0);

        assertThat(version1.isLessThan(version2)).isFalse();
        assertThat(version1.isLessThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isGreaterThan(version2)).isFalse();
        assertThat(version1.isGreaterThanOrEqualTo(version2)).isTrue();

        assertThat(version1.isEqualTo(version2)).isTrue();
    }

}