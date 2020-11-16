package my.project;

import my.project.version.VersionFactory;
import my.project.version.SemanticVersion;

public class Application {

    public static void main(String[] args) {
        VersionFactory factory = new VersionFactory();

        SemanticVersion v3 = factory.buildSemanticVersion("3");
        SemanticVersion v3_0 = factory.buildSemanticVersion("3.0");
        SemanticVersion v3_0_0 = factory.buildSemanticVersion("3.0.0");

        System.out.println("v1 is equal to v1_0: " + v3.isEqualTo(v3_0));
        System.out.println("v1 is equal to v1_0_0: " + v3.isEqualTo(v3_0_0));
        System.out.println("v1_0 is equal to v1_0_0: " + v3_0.isEqualTo(v3_0_0));

        SemanticVersion v2_0_0 = factory.buildSemanticVersion("2.0.0");
        SemanticVersion v2_0_1 = factory.buildSemanticVersion("2.0.1");

        System.out.println("v2_0_0 is less than v2_0_1: " + v2_0_0.isLessThan(v2_0_1));
        System.out.println("v2_0_1 is greater than v2_0_0: " + v2_0_1.isGreaterThan(v2_0_0));

        SemanticVersion v2_10_0 = factory.buildSemanticVersion("2.10.0");
        SemanticVersion v2_4_8 = factory.buildSemanticVersion("2.4.8");

        System.out.println("v2_10_0 is greater than or equal to v2_4_8: " + v2_10_0.isGreaterThanOrEqualTo(v2_4_8));
        System.out.println("v2_4_8 is less than or equal to v2_10_0: " + v2_4_8.isLessThanOrEqualTo(v2_10_0));

        try {
            factory.buildSemanticVersion("1.9.8.9");
        } catch (IllegalArgumentException exception) {
            System.out.println("1.9.8.9 is invalid. " + exception.getMessage());
        }

        SemanticVersion v2_99_99 = factory.buildSemanticVersion("2.99.99");

        System.out.println("v3 is greater than v2_99_99: " + v3.isGreaterThan(v2_99_99));
        System.out.println("v2_99_99 is less than v3: " + v2_99_99.isLessThan(v3));
    }

}
