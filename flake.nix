{
  description = "TODO";

  inputs.nixpkgs.url = "github:NixOs/nixpkgs/nixos-unstable";
  inputs.flake-utils.url = "github:numtide/flake-utils";

  outputs = { self, nixpkgs, flake-utils }:
    flake-utils.lib.simpleFlake {
      inherit self nixpkgs;
      name = "zio-logging-example";
      shell = ./shell.nix;
    };
}
