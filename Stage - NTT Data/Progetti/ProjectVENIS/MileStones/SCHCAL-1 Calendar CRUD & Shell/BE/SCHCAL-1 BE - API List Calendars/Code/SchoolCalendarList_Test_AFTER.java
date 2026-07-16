
// *TEST: SchoolCalendarBackOfficeResourceTest.java

@ExtendWith(MockitoExtension.class)
class SchoolCalendarBackOfficeResourceTest {

    private MockMvc mockMvc;

    @Mock
    private SchoolCalendarQueryService schoolCalendarQueryService;

    @InjectMocks
    private SchoolCalendarBackOfficeResource schoolCalendarBackOfficeResource;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(schoolCalendarBackOfficeResource).build();
    }

    // ?TEST: method calling in the main MOCKIJTO one
    @Test
    void getAllSchoolCalendars_shouldReturnOkAndPayload() throws Exception {

        SchoolCalendarListResponseDTO dto = new SchoolCalendarListResponseDTO();
        dto.setId(1L);
        dto.setSchoolYear("2026-2027");
        dto.setName("Test Calendar");

        when(schoolCalendarQueryService.getAllCalendarsForBackoffice())
            .thenReturn(Collections.singletonList(dto));


        mockMvc.perform(get("/api/supplenti-bo/school-calendars")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.data", hasSize(1)))
            .andExpect(jsonPath("$.data[0].id").value(1))
            .andExpect(jsonPath("$.data[0].schoolYear").value("2026-2027"))
            .andExpect(jsonPath("$.data[0].name").value("Test Calendar"));
    }
}
