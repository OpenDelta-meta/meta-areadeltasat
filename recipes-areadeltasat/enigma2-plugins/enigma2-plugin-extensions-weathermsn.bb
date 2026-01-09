SUMMARY = "Weather MSN - Weather forecast for five days"
DESCRIPTION = "Weather forecast for 5 days"
MAINTAINER = "Sirius"
HOMEPAGE = "www.gisclub.tv"
require conf/license/license-gplv2.inc

inherit gittag allarch python3-compileall

PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = "git://github.com/OpenDeltaE2-Plugins/enigma2-plugins-weathermsn.git;protocol=https;branch=master"

FILES:${PN} = "${prefix}/"

S = "${WORKDIR}/git"

do_compile() {
	python3 -O -m compileall ${S}${libdir}/enigma2/python/Components/
}

do_install() {
	install -d ${D}${prefix}
	cp -r ${S}${prefix}/* ${D}${prefix}/
}
