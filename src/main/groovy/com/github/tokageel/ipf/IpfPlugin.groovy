package com.github.tokageel.ipf

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Delete

class IpfPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("addon", IpfPluginExtension, project)

        project.task('clean', type: Delete) {
            delete project.file("${project.buildDir}")
        }

        project.task('build', dependsOn: 'clean') << {
            project.copy {
                from "${project.addon.sourceDir}"
                into "${project.addon.intermediatePath}"
            }
            project.exec {
                workingDir "${project.buildDir}"
                commandLine 'ipf', "${project.addon.ipfFileName}", "${project.addon.name}"
            }
        }

        project.task('info') << {
            println "name: ${project.addon.name}"
            println "version: ${project.addon.version}"
            println "unicode: ${project.addon.unicode}"
            println "source: ${project.addon.sourceDir}"
            println "filename: ${project.addon.ipfFileName}"
            println "intermediate: ${project.addon.intermediatePath}"
        }
    }
}
