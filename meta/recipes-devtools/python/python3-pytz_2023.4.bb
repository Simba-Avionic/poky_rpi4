SUMMARY = "World timezone definitions, modern and historical"
HOMEPAGE = "http://pythonhosted.org/pytz"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=1a67fc46c1b596cce5d21209bbe75999"

inherit pypi setuptools3 ptest

SRC_URI[sha256sum] = "31d4583c4ed539cd037956140d695e42c033a19e984bfce9964a3f7d59bc2b40"

RDEPENDS:${PN}:class-target += "\
    python3-datetime \
    python3-doctest \
    python3-io \
    python3-pickle \
    python3-pprint \
    python3-threading \
"

BBCLASSEXTEND = "native nativesdk"

SRC_URI += " \
	file://run-ptest \
"

RDEPENDS:${PN}-ptest += " \
	python3-pytest \
	python3-unittest-automake-output \
"

do_install_ptest() {
	install -d ${D}${PTEST_PATH}/pytz
	install -d ${D}${PTEST_PATH}/pytz/tests
	cp -rf ${S}/pytz/tests/* ${D}${PTEST_PATH}/pytz/tests/
	cp -f ${S}/README.rst ${D}${PTEST_PATH}/

}
