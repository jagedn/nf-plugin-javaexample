include { randomString } from 'plugin/nf-plugin-javatemplate'

channel.of( randomString(10) ) | map { it.toUpperCase() } | view