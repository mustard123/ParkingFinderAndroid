package com.example.silas.parkingfinder;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    String xml =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<rss xmlns:dc=\"http://purl.org/dc/elements/1.1/\" version=\"2.0\">\n" +
            "  <channel>\n" +
            "    <link>http://www.plszh.ch</link>\n" +
            "    <description>http://www.plszh.ch/plsFeed/rss?type=rss_0.92 | rss_0.93 | rss_0.94 | rss_1.0 | rss_2.0 (=default) | atom_0.3 | atom_1.0</description>\n" +
            "    <copyright>Nutzungsbedingungen entsprechen der Creative-Commons-Null-Lizenz (CC-0)</copyright>\n" +
            "    <dc:rights>Nutzungsbedingungen entsprechen der Creative-Commons-Null-Lizenz (CC-0)</dc:rights>\n" +
            "    <item>\n" +
            "      <title>Parkgarage am Central / Seilergraben</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/central.jsp?pid=central</link>\n" +
            "      <description>open /   20</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/central.jsp?pid=central</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Accu / Otto-Schütz-Weg</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/accu.jsp?pid=accu</link>\n" +
            "      <description>open /  140</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/accu.jsp?pid=accu</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Albisriederplatz / Badenerstrasse 380</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/albisriederplatz.jsp?pid=albisriederplatz</link>\n" +
            "      <description>open /   49</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/albisriederplatz.jsp?pid=albisriederplatz</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Bleicherweg / Beethovenstrasse 35</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/bleicherweg.jsp?pid=bleicherweg</link>\n" +
            "      <description>open /    1</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/bleicherweg.jsp?pid=bleicherweg</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Center Eleven / Sophie-Täuber-Strasse 4</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/center_11.jsp?pid=center_11</link>\n" +
            "      <description>open /  175</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/center_11.jsp?pid=center_11</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus City Parking / Gessnerallee 14</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/cp.jsp?pid=cp</link>\n" +
            "      <description>open /  225</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/cp.jsp?pid=cp</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Cityport / Affolternstrasse 56</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/cityport.jsp?pid=cityport</link>\n" +
            "      <description>open /   30</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/cityport.jsp?pid=cityport</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Crowne Plaza / Badenerstrasse 420</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/crowne_plaza.jsp?pid=crowne_plaza</link>\n" +
            "      <description>open /  594</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/crowne_plaza.jsp?pid=crowne_plaza</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Dorflinde / Schwamendingenstrasse 31</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/dorflinde.jsp?pid=dorflinde</link>\n" +
            "      <description>open /   29</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/dorflinde.jsp?pid=dorflinde</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Feldegg / Riesbachstrasse 7</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/feldegg.jsp?pid=feldegg</link>\n" +
            "      <description>open /   41</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/feldegg.jsp?pid=feldegg</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Globus / Löwenstrasse 50</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/globus.jsp?pid=globus</link>\n" +
            "      <description>open /    8</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/globus.jsp?pid=globus</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Hardau II / Bullingerstrasse 73</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/hardau.jsp?pid=hardau</link>\n" +
            "      <description>open /  102</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/hardau.jsp?pid=hardau</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Hauptbahnhof / Sihlquai 41</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/hb.jsp?pid=hb</link>\n" +
            "      <description>open /  101</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/hb.jsp?pid=hb</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Hohe Promenade / Rämistrasse 22a</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/promenade.jsp?pid=promenade</link>\n" +
            "      <description>open /  290</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/promenade.jsp?pid=promenade</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Jelmoli / Steinmühleplatz 1</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/jelmoli.jsp?pid=jelmoli</link>\n" +
            "      <description>open /    0</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/jelmoli.jsp?pid=jelmoli</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Jungholz / Jungholzstrasse 19</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/jungholz.jsp?pid=jungholz</link>\n" +
            "      <description>open /   92</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/jungholz.jsp?pid=jungholz</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Max-Bill-Platz / Armin-Bollinger-Weg</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/max_bill_platz.jsp?pid=max_bill_platz</link>\n" +
            "      <description>open /   42</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/max_bill_platz.jsp?pid=max_bill_platz</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Messe Zürich AG / Andreasstrasse 65</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/messe.jsp?pid=messe</link>\n" +
            "      <description>open /  999</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/messe.jsp?pid=messe</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Nordhaus / Siewerdtstrasse 8</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/nordhaus.jsp?pid=nordhaus</link>\n" +
            "      <description>open /   32</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/nordhaus.jsp?pid=nordhaus</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Octavo / Brown-Boveri-Strasse 2</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/octavo.jsp?pid=octavo</link>\n" +
            "      <description>open /    2</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/octavo.jsp?pid=octavo</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Opéra / Schillerstrasse 5</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/opera.jsp?pid=opera</link>\n" +
            "      <description>open /   45</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/opera.jsp?pid=opera</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus P West / Förrlibuckstrasse 151</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/p_west.jsp?pid=p_west</link>\n" +
            "      <description>open /  331</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/p_west.jsp?pid=p_west</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Park Hyatt / Beethovenstrasse 21</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/park_hyatt.jsp?pid=park_hyatt</link>\n" +
            "      <description>open /   82</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/park_hyatt.jsp?pid=park_hyatt</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Parkside / Sophie-Täuber-Strasse 10</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/parkside.jsp?pid=parkside</link>\n" +
            "      <description>open /    3</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/parkside.jsp?pid=parkside</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Pfingstweid / Pfingstweidstrasse 1</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/pfingstweid.jsp?pid=pfingstweid</link>\n" +
            "      <description>open /   78</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/pfingstweid.jsp?pid=pfingstweid</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Stampfenbach / Niklausstrasse 1</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/stampfenbach.jsp?pid=stampfenbach</link>\n" +
            "      <description>open /   59</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/stampfenbach.jsp?pid=stampfenbach</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Talgarten / Nüschelerstrasse 31</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/talgarten.jsp?pid=talgarten</link>\n" +
            "      <description>open /    0</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/talgarten.jsp?pid=talgarten</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus USZ Nord / Frauenklinikstrasse</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/unispital_nord.jsp?pid=unispital_nord</link>\n" +
            "      <description>open /    1</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/unispital_nord.jsp?pid=unispital_nord</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Uni Irchel / Winterthurerstrasse 181</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/uni_irchel.jsp?pid=uni_irchel</link>\n" +
            "      <description>???? / ???</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/uni_irchel.jsp?pid=uni_irchel</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Urania / Uraniastrasse 3</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/urania.jsp?pid=urania</link>\n" +
            "      <description>open /    0</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/urania.jsp?pid=urania</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Utoquai / Färberstrasse 6</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/utoquai.jsp?pid=utoquai</link>\n" +
            "      <description>open /    0</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/utoquai.jsp?pid=utoquai</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Züri 11 Shopping / Nansenstrasse 5/7</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/zueri11.jsp?pid=zueri11</link>\n" +
            "      <description>open /   26</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/zueri11.jsp?pid=zueri11</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkhaus Zürichhorn / Dufourstrasse 142</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/zuerichhorn.jsp?pid=zuerichhorn</link>\n" +
            "      <description>open /   43</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/zuerichhorn.jsp?pid=zuerichhorn</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkplatz Bienen / Bienen-/Herdernstrasse</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/bienen.jsp?pid=bienen</link>\n" +
            "      <description>open /    0</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/bienen.jsp?pid=bienen</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkplatz Eisfeld / Thurgauerstrasse 54</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/eisfeld.jsp?pid=eisfeld</link>\n" +
            "      <description>open /   68</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/eisfeld.jsp?pid=eisfeld</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkplatz Theater 11 / Dörfli-/Thurgauerstrasse</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/theater_11.jsp?pid=theater_11</link>\n" +
            "      <description>open /  154</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/theater_11.jsp?pid=theater_11</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "    <item>\n" +
            "      <title>Parkplatz USZ Süd / Gloriastrasse</title>\n" +
            "      <link>http://www.plszh.ch/parkhaus/unispital_sued.jsp?pid=unispital_sued</link>\n" +
            "      <description>open /    4</description>\n" +
            "      <pubDate>Wed, 20 Dec 2017 10:29:25 GMT</pubDate>\n" +
            "      <guid>http://www.plszh.ch/parkhaus/unispital_sued.jsp?pid=unispital_sued</guid>\n" +
            "      <dc:date>2017-12-20T10:29:25Z</dc:date>\n" +
            "    </item>\n" +
            "  </channel>\n" +
            "</rss>\n" +
            "\n";
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.silas.parkingfinder", appContext.getPackageName());
    }

    @Test
    public void parserTest() {

        List result = null;

        try {
            ParkingDataParser parkingDataParser = new ParkingDataParser(XmlPullParserFactory.newInstance().newPullParser());
            result = parkingDataParser.parse(new StringReader(xml));
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        assertFalse(result.isEmpty());
    }
}
