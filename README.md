### Version strings

Versions strings in this context are semver-like (https://semver.org/) in that they have a numerical major, minor and patch section

`X.Y.Z`

Where `X` is the major version, `Y` is the minor version, `Z` is the patch version.

The values sections (X, Y, Z) must all be positive integers.

You can ignore suffixes to the version string such as "alpha" in 10.1.3-alpha

The lower version numbers are optional and if missing are equivalent to 0. E.G. 

`3 == 3.0 == 3.0.0`

### Comparison

The required comparisons are: 
- Greater than 
- Greater than or equal to 
- Less than 
- Less than or equal to 
- Equal to

#### Examples 

`2.0.0 < 2.0.1`

`2.10.0 > 2.4.8`

`1.9.8.9 is invalid`

`3 > 2.99.99`