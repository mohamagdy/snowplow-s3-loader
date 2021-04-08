/*
 * Copyright (c) 2014-2020 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
import sbt._

object Dependencies {
  val resolvers = Seq(
    ("Snowplow Analytics Maven releases repo" at "http://maven.snplow.com/releases/").withAllowInsecureProtocol(true),
    "Snowplow Bintray Maven repo"            at "https://snowplow.bintray.com/snowplow-maven"
  )

  object V {
    // Java
    val slf4j            = "1.7.30"
    val log4j            = "2.14.0"
    val kinesisClient    = "1.7.5"
    val kinesisConnector = "1.3.0"
    val hadoop           = "2.7.3"
    val elephantbird     = "4.15"
    val hadoopLZO        = "0.4.20"
    val apacheCommons    = "3.2.1"
    val jodaTime         = "2.9.9"
    val config           = "1.3.1"
    val nsqClient        = "1.1.0-rc1"
    val jacksonCbor      = "2.8.8"
    // Thrift (test only)
    val collectorPayload = "0.0.0"
    // Scala
    val scopt           = "4.0.0"
    val cats            = "2.3.0"
    val snowplowTracker = "0.7.0"
    val pureconfig      = "0.14.0"
    val igluCore        = "1.0.0"
    // Scala (test only)
    val specs2          = "4.10.5"
  }

  object Libraries {
    // Java
    val slf4j            = "org.slf4j"                 %  "slf4j-simple"              % V.slf4j
    val log4jOverSlf4j   = "org.slf4j"                 %  "log4j-over-slf4j"          % V.slf4j
    val log4jCore        = "org.apache.logging.log4j"  %  "log4j-core"                % V.log4j
    val log4jApi         = "org.apache.logging.log4j"  %  "log4j-api"                 % V.log4j
    val kinesisClient    = "com.amazonaws"             %  "amazon-kinesis-client"     % V.kinesisClient
    val kinesisConnector = "com.amazonaws"             %  "amazon-kinesis-connectors" % V.kinesisConnector
    val jacksonCbor      = "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % V.jacksonCbor
    val hadoop           = ("org.apache.hadoop"        %  "hadoop-common"             % V.hadoop)
      .exclude("org.slf4j", "slf4j-log4j12")
      .exclude("commons-beanutils", "commons-beanutils")
      .exclude("commons-beanutils", "commons-beanutils-core")
      .exclude("commons-collections", "commons-collections")
      .exclude("commons-logging", "commons-logging")
      .exclude("org.apache.htrace", "htrace-core")
      .exclude("junit", "junit")
    val elephantbird     = ("com.twitter.elephantbird"   %  "elephant-bird-core"            % V.elephantbird)
      .exclude("com.hadoop.gplcompression", "hadoop-lzo")
    val hadoopLZO        = "com.snowplowanalytics"       %  "hadoop-lzo"                    % V.hadoopLZO
    val apacheCommons    = "org.apache.directory.studio" % "org.apache.commons.collections" % V.apacheCommons
    val jodaTime         = "joda-time"                   %  "joda-time"                     % V.jodaTime
    val config           = "com.typesafe"                %  "config"                        % V.config
    val nsqClient        = "com.snowplowanalytics"       %  "nsq-java-client_2.10"          % V.nsqClient
    // Thrift (test only)
    val collectorPayload = "com.snowplowanalytics"       %  "collector-payload-1"           % V.collectorPayload % "test"
    // Scala
    val scopt            = "com.github.scopt"          %% "scopt"                     % V.scopt
    val cats             = "org.typelevel"             %% "cats-core"                 % V.cats
    val snowplowTracker  = "com.snowplowanalytics"     %% "snowplow-scala-tracker-emitter-id" % V.snowplowTracker
    val pureconfig       = "com.github.pureconfig"     %% "pureconfig"                % V.pureconfig
    // Scala (test only)
    val specs2           = "org.specs2"                  %% "specs2-core"                   % V.specs2           % "test"
  }
}
