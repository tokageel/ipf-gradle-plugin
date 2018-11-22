package com.github.tokageel.ipf

import org.gradle.api.Project

class IpfPluginExtension {
    String name
    String version
    String unicode
    String sourceDir
    final String rootDir
    final String buildDir

    IpfPluginExtension(Project project) {
        // read only
        buildDir = "${project.buildDir}"
        rootDir = "${project.rootDir}"
        // customizable
        name = "${project.name}"
        version = "${project.version}"
        unicode = "🦎"
        sourceDir = "src"
    }

    String getSourceDir() {
        return "${rootDir}/${sourceDir}"
    }

    String getIntermediatePath() {
        return "${buildDir}/${name}/addon_d.ipf/${name}"
    }

    String getIpfFileName() {
        return "_${name}-${unicode}-v${version}.ipf"
    }
}
