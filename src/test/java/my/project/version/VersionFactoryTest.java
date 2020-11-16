package my.project.version;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionFactoryTest {

    private final VersionFactory versionFactory = new VersionFactory();

    @Test
    public void shouldCreateVersionFromStringWithThreeNumbers() {
        // given
        String versionString = "1.22.333";

        // when
        SemanticVersion semanticVersion = versionFactory.buildSemanticVersion(versionString);

        // then
        assertThat(semanticVersion.getMajor()).isEqualTo(1);
        assertThat(semanticVersion.getMinor()).isEqualTo(22);
        assertThat(semanticVersion.getPatch()).isEqualTo(333);
    }

    @Test
    public void shouldCreateVersionFromStringWithTwoNumbers() {
        // given
        String versionString = "11.2";

        // when
        SemanticVersion semanticVersion = versionFactory.buildSemanticVersion(versionString);

        // then
        assertThat(semanticVersion.getMajor()).isEqualTo(11);
        assertThat(semanticVersion.getMinor()).isEqualTo(2);
        assertThat(semanticVersion.getPatch()).isEqualTo(0);
    }

    @Test
    public void shouldCreateVersionFromStringWithOneNumber() {
        // given
        String versionString = "444";

        // when
        SemanticVersion semanticVersion = versionFactory.buildSemanticVersion(versionString);

        // then
        assertThat(semanticVersion.getMajor()).isEqualTo(444);
        assertThat(semanticVersion.getMinor()).isEqualTo(0);
        assertThat(semanticVersion.getPatch()).isEqualTo(0);
    }

    @Test
    public void shouldCreateVersionFromStringWithZerosOnly() {
        // given
        String versionString = "0.0.0";

        // when
        SemanticVersion semanticVersion = versionFactory.buildSemanticVersion(versionString);

        // then
        assertThat(semanticVersion.getMajor()).isEqualTo(0);
        assertThat(semanticVersion.getMinor()).isEqualTo(0);
        assertThat(semanticVersion.getPatch()).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateVersionFromIncorrectString() {
        // given
        String versionString = "1.2..3";

        // when & then
        versionFactory.buildSemanticVersion(versionString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateVersionFromStringWithNegativeNumbers() {
        // given
        String versionString = "1.-2.3";

        // when & then
        versionFactory.buildSemanticVersion(versionString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateVersionFromStringWithLeadingZeros() {
        // given
        String versionString = "1.02.3";

        // when & then
        versionFactory.buildSemanticVersion(versionString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToCreateVersionFromEmptyString() {
        // given
        String versionString = "";

        // when & then
        versionFactory.buildSemanticVersion(versionString);
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailToCreateVersionFromNullableString() {
        // given
        String versionString = null;

        // when & then
        versionFactory.buildSemanticVersion(versionString);
    }
}