__author__ = 'Kaiyuan_Wang'

import sys
import re

has_build_tag = False
has_plugins_tag = False

has_jacoco_plugin = False
has_surefire_plugin = False
has_config_tag = False

jacoco_plugin = \
'''
      <plugin>
        <groupId>org.jacoco</groupId>
        <artifactId>jacoco-maven-plugin</artifactId>
        <version>0.7.6.201602180812</version>
        <executions>
          <execution>
            <id>pre-unit-test</id>
            <goals>
              <goal>prepare-agent</goal>
            </goals>
            <configuration>
              <destFile>${project.build.directory}/coverage-reports/jacoco-ut.exec</destFile>
              <propertyName>surefireArgLine</propertyName>
            </configuration>
          </execution>
          <execution>
            <id>post-unit-test</id>
            <phase>test</phase>
            <goals>
              <goal>report</goal>
            </goals>
            <configuration>
              <dataFile>${project.build.directory}/coverage-reports/jacoco-ut.exec</dataFile>
              <outputDirectory>${project.basedir}/jacoco-ut/${project.artifactId}</outputDirectory>
            </configuration>
          </execution>
        </executions>
      </plugin>
'''

surefire_plugin = \
'''
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <configuration>
          <argLine>${surefireArgLine}</argLine>
        </configuration>
      </plugin>
'''

surefire_argline = \
'''
          <argLine>${surefireArgLine}</argLine>
'''

def fill_before(content, stop_pattern, pom):
    result = re.match(r'(?s)(.*)(' + stop_pattern + ')(.*)', pom)
    return (result.group(1) + content + result.group(2) + result.group(3))

def fill_after(content, stop_pattern, pom):
    result = re.match(r'(?s)(.*)(' + stop_pattern + ')(.*)', pom)
    return (result.group(1) + result.group(2) + content + result.group(3))

def replace_center(content, stop_pattern, pom):
    result = re.match(r'(?s)(.*)(' + stop_pattern + ')(.*)', pom)
    return (result.group(1) + content + result.group(3))

def main(dst):
    # jacoco = open(src)
    # src_string = ''
    # for line in jacoco:
    #     src_string += line
    # jacoco.close()
    # pom = open(dst, 'r')
    # dst_string = ''
    # for line in pom:
    #     if '</project>' in line:
    #         dst_string += src_string + '\n' + line
    #         break
    #     dst_string += line
    # pom = open(dst, 'r+')
    # pom.write(dst_string)
    # pom.truncate()
    # pom.close()

    pom = open(dst, 'r')
    pom_string = ''
    for line in pom:
        pom_string += line
    has_build_tag = re.match(r'(?s).*(<build>.*?</build>).*', pom_string) is not None
    has_plugins_tag = re.match(r'(?s).*(<build>.*?<plugins>.*?</plugins>.*?</build>).*', pom_string) is not None
    has_jacoco_plugin = re.match(r'(?s).*(<build>.*?<plugins>.*?<plugin>.*?<artifactId>jacoco-maven-plugin</artifactId>.*?</plugin>.*?</plugins>.*?</build>).*', pom_string) is not None
    has_surefire_plugin = re.match(r'(?s).*(<build>.*?<plugins>.*?<plugin>.*?<artifactId>maven-surefire-plugin</artifactId>.*?</plugin>.*?</plugins>.*?</build>).*', pom_string) is not None
    has_config_tag = re.match(r'(?s).*(<build>.*?<plugins>.*?<plugin>.*?<artifactId>maven-surefire-plugin</artifactId>.*?<configuration>.*?</configuration>.*?</plugin>.*?</plugins>.*?</build>).*', pom_string) is not None

    # print has_build_tag
    # print has_plugins_tag
    # print has_surefire_plugin
    # print has_config_tag

    if not has_build_tag:
        pom_string = \
        fill_before(
            '  <build>\n'
            '    <plugins>\n'
            + jacoco_plugin
            + surefire_plugin
            +
            '    </plugins>\n'
            '  </build>\n'
            , '</project>', pom_string)
    elif not has_plugins_tag:
        pom_string = \
        fill_before(
            '    <plugins>\n'
            + jacoco_plugin
            + surefire_plugin
            +
            '    </plugins>\n'
            , '</build>', pom_string)
    else:
        if not has_jacoco_plugin:
            pom_string = \
            fill_before(
            jacoco_plugin
            , '</plugins>', pom_string)
        else:
            pom_string = \
            replace_center(
            jacoco_plugin
            , '<plugin>.*?<artifactId>jacoco-maven-plugin</artifactId>.*?</plugin>', pom_string
            )
        if not has_surefire_plugin:
            pom_string = \
            fill_before(
            jacoco_plugin
            + surefire_plugin
            , '</plugins>', pom_string)
        else:
            if not has_config_tag:
                pom_string = \
                fill_after(
                   '      <configuration>\n'
                   + surefire_argline
                   +
                   '      </configuration>\n'
                , '<artifactId>.*?maven-surefire-plugin.*?</artifactId>', pom_string)
            else:
                pom_string = \
                fill_after(
                    surefire_argline
                , '<artifactId>.*?maven-surefire-plugin.*?</artifactId>.*?<configuration>', pom_string)
    pom = open(dst, 'r+')
    pom.write(pom_string)
    pom.truncate()
    pom.close()

if __name__ == '__main__':
    if not len(sys.argv) == 2:
        print 'Usage: python jacoco.py dst'
    # src = ''#sys.argv[1]
    dst = sys.argv[1]
    main(dst)