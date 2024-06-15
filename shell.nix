{ pkgs ? import <nixpkgs> {}}:

pkgs.mkShell {
  buildInputs = [
    pkgs.scala_3
    (pkgs.sbt-extras.override { jdk = pkgs.zulu8; })
    pkgs.zulu8
  ];
}
