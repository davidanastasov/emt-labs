package com.davidanastasov.emtlabproject.security;

public class JwtConstants {
    public static final String SECRET_KEY = "e50981462981553433a8191865c93f1a5748afb18a776af29eed477706e5aff5e86ed32d1c7cf71cda9c3dba1f2ff7dec0598a08f2c4c07603195f172cd8c00d3911a9db1a62c28b6572ef21f06fb251fe94686f68aa8032392368f31587681cbdba00b4e0d3015f9aa20c7750fd02c3056f157f854c439712fd251e0c0b700188be3425bb8da5e68e03899c75cd367ee609921c0324bd67072b873e04fc6902f874a777654da02b041c77f6317c8660819ee0c924c6805d471894af0834533e138dedffa7589d65b032f7e3ee46b7f19ff27972c4c668d23d6932f24fd287892b6acd78c30056d6b0e33601fdf8ac1013a483435ecd8f9cd35c35e83263766c";
    public static final Long EXPIRATION_TIME = 864000000L;
    public static final String HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
